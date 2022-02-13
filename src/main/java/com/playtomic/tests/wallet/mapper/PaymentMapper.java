package com.playtomic.tests.wallet.mapper;

import com.playtomic.tests.wallet.entity.Payment;
import com.playtomic.tests.wallet.model.PaymentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDto toDto(Payment entity);

    Payment toEntity(PaymentDto dto);

}
