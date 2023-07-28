package pojo.inter;

import pojo.accountTable;

import java.util.List;

public interface accountMapper {
    List<accountTable> FindAll();

    int deleteByPrimaryKey(String id);

    int insert(accountTable ac);

    accountTable selectPrimaryKey(String id);

    int updateByPrimayKey(accountTable ac);
}
