package com.devchina.ormdemo;

import java.util.List;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalDb;
import net.tsz.afinal.annotation.view.ViewInject;
import net.tsz.afinal.db.sqlite.DbModel;
import android.os.Bundle;
import android.widget.TextView;

public class AfinalOrmDemoActivity extends FinalActivity {
	
	
	@ViewInject(id=R.id.textView) TextView textView; //����ʹ����afinal��ioc���ܣ��Ժ󽫻ὲ��
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String where = "UserId="+12;
        FinalDb db = FinalDb.create(this, null, "wangmq", false, 5, null);
        
        
        //***************����ѯ***********************//
        OneBO oneBo = new OneBO();
        oneBo.setUserId(12);
        oneBo.setOneString("OneString");
        db.save(oneBo);
        List<OneBO> List1 = db.findAll(OneBO.class);
        
        TwoBO twoBo =new TwoBO();
        twoBo.setUserId(12);
        twoBo.setTwoString("TwoString");
        db.save(twoBo);
        List<TwoBO> List2 = db.findAll(TwoBO.class);
        
        ThreeBO threeBo = new ThreeBO();
        threeBo.setUserId(12);
        threeBo.setThreeString("ThreeString");
        db.save(threeBo);
        
        //*************�޸�����************************//
        List<ThreeBO> List3 = db.findAllByWhere(ThreeBO.class, "UserId="+13);
        if(List3!=null&&List3.size()>0){
        	db.update(threeBo, "UserId="+12);
        }else {
        	threeBo.setUserId(13);
        	db.save(threeBo);
        }
        
        DbModel model = db.findDbModelBySQL("select * from OneBO a ,TwoBO b ,ThreeBO c where a.UserId=b.UserId and a.UserId=c.UserId");
        model.getString("OneString");
        model.getString("TwoString");
        model.getString("ThreeString");
//        List<DbModel> list = db.findDbModelListBySQL("select * from User a ,TestBo b  where a.UserId = b.UserId");
//       for(DbModel user1:list){
//    	   user1.getString("testString");
//       }
        
        //****************ɾ������**********************//
        db.deleteByWhere(ThreeBO.class, "UserId="+12);//ɾ����������������
        List<ThreeBO> List4 = db.findAll(ThreeBO.class);
        db.deleteByWhere(ThreeBO.class, null);// ɾ��ThreeBO���е���������
        List<ThreeBO> List5 = db.findAll(ThreeBO.class);
    }
}