import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.accountTable;
import pojo.inter.accountMapper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

public class accountService {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private accountMapper mapper;
    public accountService() throws IOException {
        String resource = "mybatis-demo.xml";
        inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(accountMapper.class);
    }
    private void destory(SqlSession sqlSession,InputStream inputStream){
        sqlSession.commit();
        sqlSession.close();
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void FindAll() throws IOException {
        List<accountTable> res = mapper.FindAll();
        System.out.println(res);
        destory(sqlSession,inputStream);
    }

    public void deleteByPrimaryKey(String id) throws IOException {
        int lines = mapper.deleteByPrimaryKey(id);
        System.out.println("influenced lines is "+lines);
        destory(sqlSession,inputStream);
    }

    public void insert(accountTable ac) throws IOException {
        int insert = mapper.insert(ac);
        sqlSession.commit();
        System.out.println("influenced lines is "+insert);
        destory(sqlSession,inputStream);
    }

    public void selectPrimaryKey(String id) throws IOException {
        accountTable ac = mapper.selectPrimaryKey(id);
        System.out.println(ac);
        destory(sqlSession,inputStream);
    }

    public void updateByPrimayKey(accountTable ac) throws IOException {
        mapper.updateByPrimayKey(ac);
        destory(sqlSession,inputStream);
    }

    public void transfer(String remitterid,String remitteeid,int money) throws IOException {
        accountTable remitter = new accountTable();
        accountTable remittee = new accountTable();
        remittee.setId(remitteeid);
        remitter.setId(remitterid);
        System.out.println("remitter had "+mapper.selectPrimaryKey(remitterid).getMoney()+"remittee had "+mapper.selectPrimaryKey(remitteeid).getMoney()+" money is "+money);
        remitter.setMoney(mapper.selectPrimaryKey(remitterid).getMoney()+money);
        remittee.setMoney(mapper.selectPrimaryKey(remitteeid).getMoney()-money);
        mapper.updateByPrimayKey(remittee);
        mapper.updateByPrimayKey(remitter);
        System.out.println("success transfer! remitter had "+mapper.selectPrimaryKey(remitterid).getMoney()+" remittee had "+mapper.selectPrimaryKey(remitteeid).getMoney()+". ");
        destory(sqlSession,inputStream);
    }

    public static void main(String[] args) throws IOException {
//        accountTable ac = new accountTable();
//        ac.setId("005");
//        ac.setMoney(753782);
//        ac.setName("小明");
//        ac.setCreatetime(Date.valueOf("2030-01-01"));
//        ac.setUpdatetime(Date.valueOf("2041-02-02"));
//        查找全部
//        new accountService().FindAll();
//        按照主键删除
//        new accountService().deleteByPrimaryKey("005");
//        插入数据
//        new accountService().insert(ac);
//        按照主键查找
//        new accountService().selectPrimaryKey("004");
//        按照主键更新数据
//        new accountService().updateByPrimayKey(ac);
//        根据给定id进行转账
//        new accountService().transfer("001","003",100);
    }
}
