package br.com.turn2c.api.mapper;

import br.com.turn2c.api.dto.ClienteDTO;
import br.com.turn2c.api.dto.VendedorDTO;
import br.com.turn2c.api.entity.Cliente;
import br.com.turn2c.api.entity.Vendedor;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper
public interface Mapper {

    Mapper INSTANCE = Mappers.getMapper(Mapper.class);

    Cliente toEntity(ClienteDTO dto);
    ClienteDTO toDTO(Cliente entity);

    Vendedor toEntityVendedor(VendedorDTO dto);
    VendedorDTO toDTOVendedor(Vendedor entity);

}
