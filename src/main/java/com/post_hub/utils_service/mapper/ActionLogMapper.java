package com.post_hub.utils_service.mapper;

import com.post_hub.utils_service.entity.ActionLog;
import com.post_hub.utils_service.model.dto.ActionLogDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ActionLogMapper {

    ActionLogDTO map(ActionLog log);
}
