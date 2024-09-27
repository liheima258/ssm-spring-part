package com.atguigu.service;

import com.atguigu.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    /*
        tx事务的属性：
        只读：如果设置成只读，就能够明确告诉数据库，这个操作不涉及写操作,提高查询效率 ==> readOnly = true
        超时：超时回滚，释放资源 ==> timeout设置事务超时时间,单位秒! 默认: -1 永不超时,不限制事务时间!
        事务异常：默认只针对运行时异常回滚，编译时异常不回滚。
                rollbackFor属性：指定哪些异常类才会回滚,默认是 RuntimeException and Error 异常方可回滚!
                noRollbackFor属性：指定哪些异常不会回滚, 默认没有指定,如果指定,应该在rollbackFor的范围内!
        事务隔离级别：isolation = 设置事务的隔离级别,mysql默认是repeatable read!
        事务传播行为：通过 propagation 属性设置事务的传播行为。默认值 REQUIRED ==> 如果父方法有事务，就加入，如果没有就新建自己独立！
                                                      其他值 REQUIRES_NEW ==> 不管父方法是否有事务，我都新建事务，都是独立的！
                   在同一个类中，对于@Transactional注解的方法调用，事务传播行为不会生效。
     */
    @Transactional(readOnly = true, timeout = 3, rollbackFor = Exception.class, noRollbackFor = FileNotFoundException.class,
            isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
    public void changeInfo() {
        studentDao.updateAgeById(100, 1);
        studentDao.updateNameById("test1", 1);
    }
}
