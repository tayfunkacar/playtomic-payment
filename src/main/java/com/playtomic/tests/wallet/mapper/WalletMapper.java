package com.playtomic.tests.wallet.mapper;

import com.playtomic.tests.wallet.entity.Wallet;
import com.playtomic.tests.wallet.model.WalletDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    WalletDto toDto(Wallet entity);

    Wallet toEntity(WalletDto dto);

}
