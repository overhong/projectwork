import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import pbean.Board;
import utils.MyBatisManager;


public class MyBatisTest {

	@Test
	public void test() throws IOException{
		//String resource ="mybatis/Configuration.xml";
		//Reader reader = Resources.getResourceAsReader(resource);
		//SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		
		//MyBatisManager mybatis =(MyBatisManager)
		//SqlSession session = sqlMapper.openSession();
		
		SqlSession session = MyBatisManager.getSqlSession().openSession();
		List<Board> list = session.selectList("dao.BoardDAO.getBoardList");
		// session.selectList("namespace.id");
		
		for(Board board :list){
			System.out.println(board.getNum() + " "+board.getTitle());
			
		}
		session.close();
		
	}

}
