package exam3;

public class CommandFactory {
	private CommandFactory(){}
	
	private static CommandFactory instance = new CommandFactory();
	
	public static CommandFactory newInstance(){
		return instance;
	}
	
	public Command createCommand(String cmd){
		if(cmd.equals("REGFORM")){
			return new RegFormCommand();
		}
		else if(cmd.equals("REGCONFIRM")){
			return new RegConfirmCommand();
		}
		else if(cmd.equals("REGCOMPLETE")){
			return new RegCompleteCommand();
		}
		else if(cmd.equals("MAIN")){
			return new MainCommand();
		}
		else if(cmd.equals("ZIPSEARCH")){
			return new ZipCommand();
		}
		else{
			// �������� ��û�� �ƴ϶�� �޽����� ����Ҽ��ְ� ó��
		}
		
		return null;
	}
}
