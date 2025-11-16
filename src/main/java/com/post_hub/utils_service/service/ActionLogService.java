package com.post_hub.utils_service.service;

import com.post_hub.utils_service.model.dto.ActionLogDTO;
import com.post_hub.utils_service.model.response.UtilsResponse;
import com.post_hub.utils_service.response.PaginationResponse;
import org.springframework.data.domain.Pageable;

public interface ActionLogService {

    UtilsResponse<ActionLogDTO> getActionLogById(Integer logId, Integer userId);
    UtilsResponse<PaginationResponse<ActionLogDTO>> findAllCationLogs(Pageable pageable);
}
