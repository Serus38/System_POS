package com.system.system_pos.service.TokenBlacklist;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.system_pos.model.admin.TokenBlacklist;

@Service
public interface TokenBlacklistService {

    List<TokenBlacklist> getAllTokenBlacklists();

    TokenBlacklist getTokenBlacklistById(Long id);

    TokenBlacklist save(TokenBlacklist tokenBlacklist);

    void delete(Long id);

    TokenBlacklist update(TokenBlacklist tokenBlacklist);
}
