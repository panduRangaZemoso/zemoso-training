public class Assignment8 {
    public static void main(String[] args){
        Customer customer = new Customer("pandu","11121","Zemoso");
    }
}

class Customer{
    String name;
    String mobile;
    String password;

    public Customer(String name, String mobile, String password) {
        try {
            if(name == null || "".equals(name)){
                throw new EmptyNameException("Customer name cannot be empty");
            }
            if(mobile == null || mobile.length() != 10 || !mobile.chars().allMatch( Character::isDigit )){
                throw new MobileNumberFormatException("Mobile number should be 10-digit numeric string");
            }
            if(password.length() < 8){
                throw new PasswordFormatException("Password should be minimum 8 characters long");
            }
            this.name = name;
            this.mobile = mobile;
            this.password = password;
        }
        catch(EmptyNameException | MobileNumberFormatException | PasswordFormatException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Customer Instance creation is called");
        }
    }
}



// EXCEPTION CLASSES
class EmptyNameException extends Exception{
    public EmptyNameException(String message) {
        super(message);
    }
}

class MobileNumberFormatException extends Exception{
    public MobileNumberFormatException(String message) {
        super(message);
    }
}

class PasswordFormatException extends Exception{
    public PasswordFormatException(String message) {
        super(message);
    }
}
