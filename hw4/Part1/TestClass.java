public class TestClass
{
    public static void main(String[] args) {
        String nickname="sibel";
		String password1="[rac()ecar]";
		int password2=35;
        boolean flag;
		boolean flag2;
		boolean flag3;
		boolean flag4;
		boolean flag5;
        Username user = new Username(nickname);
		flag= user.checkIfValidUsername(nickname);
		passwordOne pass = new passwordOne(password1);
		flag2=pass.containsUserNameSpirit(nickname);
		flag3=pass.isBalancedPassword();
		flag4 = pass.isPalindromePossible(password1);
		//----------------------------------------------------------------------//
		passwordTwo pass2 = new passwordTwo(password2);
		int[] denominations = {4,17,29};
		flag5=pass2.isExactDivision(0,denominations );
		if(user.size_gettr()==false)
			System.out.println("The username is invalid due to username size");
		else if(flag==false)
			System.out.println("The username is invalid. It should have letters only ");
		else if(pass.size_gettr()==false)
			System.out.println("Password is invalid.password has to 8 charecter");
		else if(pass.stack_size_gettr()==false)
			System.out.println("The password1 is invalid. It should have at least 2 brackets.");
		else if (flag2==false)
			System.out.println("Password is invalid. It has to includes at least one the same letter as username");
		else if (flag3==false)
			System.out.println("The password1 is invalid. It should be balanced.");
		else if (flag4==false)
			System.out.println("The password1 is invalid. It should be possible to obtain a palindrome from the password1.");
		else if(pass2.valid_num()==false)
			System.out.println("The password2 is invalid. It should be between 10 and 10,000.");
		else if(flag5==false)
			System.out.println("The password2 is invalid. It is not compatible with the denominations.");
		else
			System.out.println("The username and passwords are valid. The door is opening, please wait..");			
    }
}