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
			// 정상적인 요청이 아니라는 메시지를 출력할수있게 처리
		}
		
		return null;
	}
}
