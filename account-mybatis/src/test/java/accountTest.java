import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.accountTable;
import pojo.inter.accountMapper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

public class accountTest {
    @Test
    public void TestFindAll() throws IOException {
        String resource = "mybatis-demo.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        accountMapper mapper = sqlSession.getMapper(accountMapper.class);

        List<accountTable> res = mapper.FindAll();
        System.out.println(res);
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void TestdeleteByPrimaryKey() throws IOException {
        String resource = "mybatis-demo.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        accountMapper mapper = sqlSession.getMapper(accountMapper.class);

        String id = "002";
        int lines = mapper.deleteByPrimaryKey(id);
        System.out.println(lines);
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void Testinsert() throws IOException {
        String resource = "mybatis-demo.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        accountMapper mapper = sqlSession.getMapper(accountMapper.class);

        accountTable ac = new accountTable();
        ac.setId("005");
        ac.setMoney(55786);
        ac.setName("小明");
        ac.setCreatetime(Date.valueOf("2030-01-01"));
        ac.setUpdatetime(Date.valueOf("2041-02-02"));

        int insert = mapper.insert(ac);
        sqlSession.commit();
        System.out.println(insert);
        sqlSession.close();
        inputStream.close();

    }

    @Test
    public void TestselectPrimaryKey() throws IOException {
        String id = "001";
        String resource = "mybatis-demo.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        accountMapper mapper = sqlSession.getMapper(accountMapper.class);

        accountTable ac = mapper.selectPrimaryKey("001");
        System.out.println(ac);
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void TestupdateByPrimayKey() throws IOException {
        accountTable ac = new accountTable();
        String resource = "mybatis-demo.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        accountMapper mapper = sqlSession.getMapper(accountMapper.class);

        ac.setId("001");
        ac.setName("我是");

        mapper.updateByPrimayKey(ac);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void transfer() throws IOException {
        String remitterid = "001";
        String remitteeid = "003";
        int money = 100;
        String resource = "mybatis-demo.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        accountMapper mapper = sqlSession.getMapper(accountMapper.class);

        accountTable remitter = new accountTable();
        accountTable remittee = new accountTable();
        remittee.setId(remitteeid);
        remitter.setId(remitterid);
        System.out.println("remitter had "+mapper.selectPrimaryKey(remitterid).getMoney()+"remittee had "+mapper.selectPrimaryKey(remitteeid).getMoney()+" money is "+money);
        remitter.setMoney(mapper.selectPrimaryKey(remitterid).getMoney()+money);
        remittee.setMoney(mapper.selectPrimaryKey(remitteeid).getMoney()-money);
        mapper.updateByPrimayKey(remittee);
        mapper.updateByPrimayKey(remitter);
        sqlSession.commit();
        System.out.println("success transfer! remitter had "+mapper.selectPrimaryKey(remitterid).getMoney()+" remittee had "+mapper.selectPrimaryKey(remitteeid).getMoney()+". ");
        sqlSession.close();
        inputStream.close();


    }
}
