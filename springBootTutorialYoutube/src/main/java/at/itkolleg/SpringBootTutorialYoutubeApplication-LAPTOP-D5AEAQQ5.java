package at.itkolleg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringBootTutorialYoutubeApplication {


	public interface SaySomethingService {

		public String saySomething();
	}

	/*@Component
	public class SayHelloService implements SaySomethingService {

		@Override
		public String saySomething() {
			return "Hello World";
		}
	}*/



	public class SaySomethingConfigurableService implements SaySomethingService {
		private String whatToSay = "";


		@Override
		public String saySomething() {
			return whatToSay;
		}

		public String getWhatToSay() {
			return whatToSay;
		}

		public void setWhatToSay(String whatToSay) {
			this.whatToSay = whatToSay;
		}
	}


	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootTutorialYoutubeApplication.class, args);

		SaySomethingService saySomethingService = applicationContext.getBean(SaySomethingService.class);

		System.out.println(saySomethingService.saySomething());
	}

}
