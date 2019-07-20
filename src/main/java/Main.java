import com.apsidiscount.dao.ArticleDAO;
import com.apsidiscount.entity.Article;
import com.apsidiscount.exceptions.ApsiDiscountException;
import com.apsidiscount.service.ClientService;
import com.apsidiscount.service.ClientServiceImpl;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext("classpath:application-context.xml")) {

            ClientService clientService = appCtx.getBean(ClientService.class);

            clientService.ajouterArticleDansPanier(128, 1);
        } catch (ApsiDiscountException e) {
            e.printStackTrace();
        }
    }
}
