package com.system.system_pos.service.TokenBlacklist;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.system_pos.exception.ResourceNotFound;
import com.system.system_pos.model.admin.TokenBlacklist;
import com.system.system_pos.repository.TokenBlacklistRepository;

@Service
public class TokenBlacklistServiceImp implements TokenBlacklistService {

    private final TokenBlacklistRepository tokenBlacklistRepository;

    public TokenBlacklistServiceImp(TokenBlacklistRepository tokenBlacklistRepository) {
        this.tokenBlacklistRepository = tokenBlacklistRepository;
    }

    @Override
    public List<TokenBlacklist> getAllTokenBlacklists() {
        return tokenBlacklistRepository.findAll();
    }

    @Override
    public TokenBlacklist getTokenBlacklistById(Long id) {
        TokenBlacklist tokenBlacklist = tokenBlacklistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("TokenBlacklist not found with id: " + id));
        return tokenBlacklist;
    }

    @Override
    public TokenBlacklist save(TokenBlacklist tokenBlacklist) {
        return tokenBlacklistRepository.save(tokenBlacklist);
    }

    @Override
    public void delete(Long id) {
        tokenBlacklistRepository.deleteById(id);
    }

    @Override
    public TokenBlacklist update(TokenBlacklist tokenBlacklist) {
        return tokenBlacklistRepository.save(tokenBlacklist);
    }
}
