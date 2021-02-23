package test;
import dao.UserAccountDAO;
import model.Account;
import model.Login;
import model.LoginLogic;

public class UserAccountDAOTest {

	public static void main(String[] args ){

		testFindByLogin1();
		testFindByLogin2();
		testExecute();
	}

	public static void testFindByLogin1() {
        Login login = new Login("abc", "1234");
        UserAccountDAO dao = new UserAccountDAO();
        Account account = dao.findByLogin(login);

        if(account != null &&
        		account.getUserId().equals("abc") &&
        		account.getPass().equals("1234") &&
        		account.getName().equals("山田　太郎") &&
        		account.getMail().equals("abc@abc.com") &&
        		account.getAuthority() == 0) {
        	System.out.println("testFindByLogin1: 成功しました");

        } else {
        	System.out.println("testFindByLogin1: 失敗しました");
        }
	}

	public static void testFindByLogin2() {
		 Login login = new Login("abc", "1234aa");
		 UserAccountDAO dao = new UserAccountDAO();
		 Account account = dao.findByLogin(login);

		 if(account == null) {
			 System.out.println("testFindByLogin2: 成功しました");
		 }else {
			 System.out.println("testFindByLogin2: 失敗しました");
		 }

	}

	public static void testExecute() {
		Login login = new Login("abc", "1234");
		LoginLogic loginLogic = new LoginLogic();
		boolean result = loginLogic.execute(login);

		if(result) {
			System.out.println("testExecute: 成功しました");
		}else {
			System.out.println("testExecute: 失敗しました");
		}
	}
}