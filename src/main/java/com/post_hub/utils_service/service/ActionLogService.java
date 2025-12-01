package com.post_hub.utils_service.service;

import com.post_hub.utils_service.model.dto.ActionLogDTO;
import com.post_hub.utils_service.model.response.UtilsResponse;
import com.post_hub.utils_service.request.ActionLogIsReadRequest;
import com.post_hub.utils_service.request.ActionLogUpdateResultDTO;
import com.post_hub.utils_service.response.PaginationResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Pageable;

public interface ActionLogService {

    UtilsResponse<ActionLogDTO> getActionLogById(Integer logId, Integer userId);
    UtilsResponse<PaginationResponse<ActionLogDTO>> findAllCationLogs(Pageable pageable);

    UtilsResponse<ActionLogUpdateResultDTO> setIsReadEqualsTrue(@NotNull ActionLogIsReadRequest request);

}
