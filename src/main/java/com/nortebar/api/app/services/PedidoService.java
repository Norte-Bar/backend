package com.nortebar.api.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nortebar.api.app.repositories.ComidaRepository;
import com.nortebar.api.app.repositories.ComidasPedidoRepository;
import com.nortebar.api.app.repositories.FuncionarioRepository;
import com.nortebar.api.app.repositories.MesaRepository;
import com.nortebar.api.app.repositories.PedidoRepository;
import com.nortebar.api.models.dtos.PedidoDTO;
import com.nortebar.api.models.dtos.PedidoResponseDTO;
import com.nortebar.api.models.entities.Comida;
import com.nortebar.api.models.entities.ComidasPedido;
import com.nortebar.api.models.entities.Funcionario;
import com.nortebar.api.models.entities.Mesa;
import com.nortebar.api.models.entities.Pedido;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {
    final PedidoRepository pedidoRepository;
    final FuncionarioRepository funcionarioRepository;
    final MesaRepository mesaRepository;
    final ComidaRepository comidaRepository;
    final ComidasPedidoRepository comidasPedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository, FuncionarioRepository funcionarioRepository,
            MesaRepository mesaRepository, ComidaRepository comidaRepository,
            ComidasPedidoRepository comidasPedidoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.mesaRepository = mesaRepository;
        this.comidaRepository = comidaRepository;
        this.comidasPedidoRepository = comidasPedidoRepository;
    }

    public List<PedidoResponseDTO> findAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();

        return pedidos.stream().map(pedido -> {
            List<Comida> comidas = pedido.getComidasPedido().stream()
                    .map(comidasPedido -> comidasPedido.getComida())
                    .toList();

            return new PedidoResponseDTO(
                    pedido.getId(),
                    pedido.getStatus(),
                    pedido.getFuncionario(),
                    pedido.getMesa(),
                    comidas);
        }).toList();

    }

    public Pedido create(PedidoDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(dto.funcionario_id())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        Mesa mesa = mesaRepository.findById(dto.mesa_id())
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));

        Pedido novoPedido = new Pedido();

        novoPedido.setFuncionario(funcionario);
        novoPedido.setMesa(mesa);
        novoPedido.setStatus(dto.status());

        Pedido pedidoSalvo = pedidoRepository.save(novoPedido);

        for (Integer comida_id : dto.comidas()) {
            Comida comida = comidaRepository.findById(comida_id)
                    .orElseThrow(() -> new RuntimeException("Comida não encontrada"));

            ComidasPedido novaComidasPedido = new ComidasPedido();
            novaComidasPedido.setPedido(pedidoSalvo);
            novaComidasPedido.setComida(comida);

            comidasPedidoRepository.save(novaComidasPedido);
        }

        Pedido retornoPedido = pedidoRepository.findById(pedidoSalvo.getId())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        return retornoPedido;
    }

    public Pedido update(Integer id, PedidoDTO dto) {
        Pedido pedidoExistente = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        Funcionario funcionario = funcionarioRepository.findById(dto.funcionario_id())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Mesa mesa = mesaRepository.findById(dto.mesa_id())
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));

        pedidoExistente.setFuncionario(funcionario);
        pedidoExistente.setMesa(mesa);
        pedidoExistente.setStatus(dto.status());

        Pedido pedidoAtualizado = pedidoRepository.save(pedidoExistente);

        comidasPedidoRepository.deleteByPedidoId(pedidoAtualizado.getId());

        for (Integer comida_id : dto.comidas()) {
            Comida comida = comidaRepository.findById(comida_id)
                    .orElseThrow(() -> new RuntimeException("Comida não encontrada"));

            ComidasPedido novaComidaPedido = new ComidasPedido();
            novaComidaPedido.setPedido(pedidoAtualizado);
            novaComidaPedido.setComida(comida);

            comidasPedidoRepository.save(novaComidaPedido);
        }

        return pedidoRepository.findById(pedidoAtualizado.getId())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado após atualização"));
    }

    @Transactional
    public void delete(Integer id) {
        comidasPedidoRepository.deleteByPedidoId(id);
        pedidoRepository.deleteById(id);
    }
}
