package com.why.why2exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.greendao.gen.DaoMaster;
import com.greendao.gen.DaoSession;
import com.greendao.gen.UserDao;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv;
    Button btn_add,btn_sel,btn_del,btn_upd;
    private UserDao userDao;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //DaoMaster与 DaoSession userdao是自动生成的
        //user是创建的向数据库中放入的数据类型的类 别忘了给这个类注解@En那个
        tv=findViewById(R.id.text);
        btn_add=findViewById(R.id.btn_add);
        btn_sel=findViewById(R.id.btn_sel);
        btn_del=findViewById(R.id.btn_del);
        btn_upd=findViewById(R.id.btn_upd);

        btn_add.setOnClickListener(this);
        btn_sel.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_upd.setOnClickListener(this);
        //创建一个数据库
        DaoMaster.DevOpenHelper devOpenHelper=new DaoMaster.DevOpenHelper(getApplicationContext(),"why.db",null);
        //给数据库写入的权限
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        //是数据库和daosession绑定
        DaoSession daoSession = daoMaster.newSession();
        //使userdao的操作能控制数据库
        userDao = daoSession.getUserDao();
        //实例化User
         user=new User(null,"greenDao lib test","");

    } @Override
    public void onClick(View v) {
        switch (v.getId()){
            //添加
            case R.id.btn_add:
                userDao.insert(user);
                break;
            //查找
            case R.id.btn_sel:
                User user1 = userDao.loadAll().get(0);
                tv.setText(user1.getName()+user1.getAge());
                break;
            //删除
            case R.id.btn_del:
                Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
                userDao.deleteAll();
                break;
            //修改
            case R.id.btn_upd:
                user.setAge("22");
                user.setName("小慧莹");
                break;
        }
    }
}
