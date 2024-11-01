package fuck.manthe.nmsl.service.impl;

import fuck.manthe.nmsl.entity.RedeemCode;
import fuck.manthe.nmsl.entity.User;
import fuck.manthe.nmsl.repository.RedeemRepository;
import fuck.manthe.nmsl.service.AnalysisService;
import fuck.manthe.nmsl.service.RedeemService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RedeemServiceImpl implements RedeemService {
    @Resource
    RedeemRepository redeemRepository;

    @Resource
    AnalysisService analysisService;

    @Override
    public RedeemCode infoOrNull(String codeString) {
        Optional<RedeemCode> redeemCode = redeemRepository.findByCode(codeString);
        return redeemCode.orElse(null);
    }

    @Override
    public void addCode(RedeemCode code) {
        redeemRepository.save(code);
    }

    @Override
    public boolean useCode(String code, User user) {
        Optional<RedeemCode> redeemCode1 = redeemRepository.findByAvailableAndCode(true, code);
        if (redeemCode1.isEmpty()) return false;
        RedeemCode redeemCode = redeemCode1.get();
        redeemCode.setAvailable(false);
        redeemCode.setRedeemer(user);
        analysisService.userRedeemed();
        redeemRepository.save(redeemCode);
        return true;
    }

    @Override
    public boolean removeCode(String code) {
        if (redeemRepository.findByCode(code).isEmpty()) return false;
        redeemRepository.deleteByCode(code);
        return true;
    }

    @Override
    public List<RedeemCode> list() {
        return redeemRepository.findAll();
    }

    @Override
    public List<RedeemCode> listAvailable() {
        return redeemRepository.findAllByAvailable(true);
    }

    @Override
    public List<RedeemCode> listSold() {
        return redeemRepository.findAllByAvailable(false);
    }

    @Override
    public void deleteAllByRedeemerUsername(String username) {
        redeemRepository.deleteAllByRedeemerUsername(username);
    }

    @Override
    public void deleteAllByRedeemer(User user) {
        redeemRepository.deleteAllByRedeemer(user);
    }
}
