package com.post_hub.utils_service.service.impl;

import com.post_hub.utils_service.entity.ActionLog;
import com.post_hub.utils_service.mapper.ActionLogMapper;
import com.post_hub.utils_service.model.constant.ApiErrorMessage;
import com.post_hub.utils_service.model.dto.ActionLogDTO;
import com.post_hub.utils_service.model.exception.NotFoundException;
import com.post_hub.utils_service.model.response.UtilsResponse;
import com.post_hub.utils_service.repository.ActionLogRepository;
import com.post_hub.utils_service.response.PaginationResponse;
import com.post_hub.utils_service.service.ActionLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActionLogServiceImpl implements ActionLogService {

    private final ActionLogRepository actionLogRepository;
    private final ActionLogMapper mapper;

    @Override
    public UtilsResponse<ActionLogDTO> getActionLogById(Integer logId, Integer userId) {
        ActionLog actionLog;

        if (userId == null){
            actionLog = actionLogRepository.findById(logId).orElseThrow(()-> new NotFoundException(ApiErrorMessage.NOT_FOUND_ACTION_LOG.getMessage(logId)));
        } else {
            actionLog = actionLogRepository.findByIdAndUserId(logId, userId)
                    .orElseThrow(()-> new NotFoundException(ApiErrorMessage.NOT_FOUND_ACTION_LOG_FOR_USER.getMessage(logId, userId)));
        }
        return UtilsResponse.createSuccessful(mapper.map(actionLog));
    }

    @Override
    public UtilsResponse<PaginationResponse<ActionLogDTO>> findAllCationLogs(Pageable pageable) {
        Page<ActionLogDTO> logs = actionLogRepository.findAll(pageable).map(mapper::map);
        PaginationResponse<ActionLogDTO> response = new PaginationResponse<>(
                logs.getContent(),
                new PaginationResponse.Pagination(
                        logs.getTotalElements(),
                        pageable.getPageSize(),
                        logs.getNumber() + 1,
                        logs.getTotalPages()
                )
        );

        return UtilsResponse.createSuccessful(response);
    }
}
