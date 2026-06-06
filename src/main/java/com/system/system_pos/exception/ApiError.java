package com.system.system_pos.exception;

import java.time.Instant;

public record ApiError (Instant timestamp, int status, String error, String message) {
    
}
