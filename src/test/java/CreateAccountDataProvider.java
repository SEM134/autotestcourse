import org.testng.annotations.DataProvider;

public class CreateAccountDataProvider {
    @DataProvider(name = "create account")
    private Object[][] createAccountData() {
        return new Object[][]{
                {"123@123.cc", "An account using this email address has already been registered. Please enter a valid password or request a new one."},
                {"", "Invalid email address."}
        };
    }
}
