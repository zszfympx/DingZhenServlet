package fuck.manthe.nmsl.service;

import fuck.manthe.nmsl.entity.VapeAccount;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface VapeAccountService {
    VapeAccount getOne();
    boolean isColdDown(VapeAccount account);
    void markColdDown(VapeAccount account);

    boolean addAccount(VapeAccount account);
    boolean removeAccount(String account);

    boolean updatePassword(String username, String newPassword) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException;
    boolean updateHwid(String username, String newHwid);

    List<VapeAccount> listAccounts();
}