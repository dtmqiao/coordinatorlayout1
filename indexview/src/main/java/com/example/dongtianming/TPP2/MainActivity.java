package com.example.dongtianming.TPP2;


import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<City> cities;
    IndexView indexView;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indexView = (IndexView) findViewById(R.id.indexView);
        initData();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new MyAdapter(cities));
        indexView.setOnIndexChangeListener(new IndexView.OnIndexChangeListener() {
            @Override
            public void indexChange(String word) {
                System.out.println("55555555555555555555555555555"+word);
                updataWord(word);
            }
        });

    }
    public void updataWord(String word){
        for (int i=0;i<cities.size();i++){
            if (word.equals(PinyinUtils.getPinyin(cities.get(i).getName().toString()).substring(0,1))){
                recyclerView.smoothScrollToPosition(i);
                System.out.println("66666666666666666666");
                return;
            }
        }
    }
    public void initData(){
        cities=new ArrayList<>();
        String[] cityString = { "北京市","天津市","石家庄市","唐山市","秦皇岛市","邯郸市","邢台市","保定市","张家口市","承德市","衡水市","廊坊市","沧州市","太原市","大同市","阳泉市","长治市","晋城市","朔州市","晋中市","运城市","忻州市",
                "临汾市","吕梁市","呼和浩特市","包头市","乌海市","赤峰市","通辽市","鄂尔多斯市","呼伦贝尔市","巴彦淖尔市","乌兰察布市","兴安盟","锡林郭勒盟","阿拉善盟","沈阳市","大连市","鞍山市","抚顺市","本溪市","丹东市",
                "锦州市","营口市","阜新市","辽阳市","盘锦市","铁岭市","朝阳市","葫芦岛市","长春市","吉林市","四平市","辽源市","通化市","白山市","松原市","白城市","延边朝鲜族自治州","哈尔滨市","齐齐哈尔市","鸡西市",
                "鹤岗市","双鸭山市","大庆市","伊春市","佳木斯市","七台河市","牡丹江市","黑河市","绥化市","大兴安岭地区","上海市","南京市","无锡市","徐州市","常州市","苏州市","南通市","连云港市","淮安市","盐城市",
                "扬州市","镇江市","泰州市","宿迁市","杭州市","宁波市","温州市","嘉兴市","湖州市","绍兴市","舟山市","衢州市","金华市","台州市","丽水市","合肥市","芜湖市","蚌埠市","淮南市","马鞍山市","淮北市","铜陵市",
                "安庆市","黄山市","滁州市","阜阳市","宿州市","巢湖市","六安市","亳州市","池州市","宣城市","福州市","厦门市","莆田市","三明市","泉州市","漳州市","南平市","龙岩市","宁德市","南昌市","景德镇市","萍乡市",
                "九江市","新余市","鹰潭市","赣州市","吉安市","宜春市","抚州市","上饶市","济南市","青岛市","淄博市","枣庄市","东营市","烟台市","潍坊市","济宁市","泰安市","威海市","日照市","莱芜市","临沂市","德州市",
                "聊城市","滨州市","菏泽市","郑州市","开封市","洛阳市","平顶山市","安阳市","鹤壁市","新乡市","焦作市","濮阳市","许昌市","漯河市","三门峡市","南阳市","商丘市","信阳市","周口市","驻马店市","济源市","武汉市",
                "黄石市","十堰市","宜昌市","襄樊市","鄂州市","荆门市","孝感市","荆州市","黄冈市","咸宁市","随州市","恩施土家族苗族自治州","仙桃市","潜江市","天门市","神农架林区","长沙市","株洲市","湘潭市",
                "衡阳市","邵阳市","岳阳市","常德市","张家界市","益阳市","郴州市","永州市","怀化市","娄底市","湘西土家族苗族自治州","广州市","韶关市","深圳市","珠海市","汕头市","佛山市","江门市","湛江市","茂名市","肇庆市",
                "惠州市","梅州市","汕尾市","河源市","阳江市","清远市","东莞市","中山市","潮州市","揭阳市","云浮市","南宁市","柳州市","桂林市","梧州市","北海市","防城港市","钦州市","贵港市","玉林市","百色市"
                ,"贺州市","河池市","来宾市","崇左市","海口市","三亚市","五指山市","琼海市","儋州市","文昌市","万宁市","东方市","定安县","屯昌县","澄迈县","临高县","白沙黎族自治县","昌江黎族自治县","乐东黎族自治县",
                "陵水黎族自治县","保亭黎族苗族自治县","琼中黎族苗族自治县","西沙群岛","南沙群岛","中沙群岛的岛礁及其海域","重庆市","成都市","自贡市","攀枝花市","泸州市","德阳市","绵阳市","广元市","遂宁市","内江市",
                "乐山市","南充市","眉山市","宜宾市","广安市","达州市","雅安市","巴中市","资阳市","阿坝藏族羌族自治州","甘孜藏族自治州","凉山彝族自治州","贵阳市","六盘水市","遵义市","安顺市","铜仁地区","黔西南布依族苗族自治州",
                "毕节地区","黔东南苗族侗族自治州","黔南布依族苗族自治州","昆明市","曲靖市","玉溪市","保山市","昭通市","丽江市","思茅市","临沧市","楚雄彝族自治州","红河哈尼族彝族自治州",
                "文山壮族苗族自治州","西双版纳傣族自治州","大理白族自治州","德宏傣族景颇族自治州","怒江傈僳族自治州","迪庆藏族自治州","拉萨市","昌都地区","山南地区","日喀则地区","那曲地区","阿里地区","林芝地区",
                "西安市","铜川市","宝鸡市","咸阳市","渭南市","延安市","汉中市","榆林市","安康市","商洛市","兰州市","嘉峪关市","金昌市","白银市","天水市","武威市","张掖市","平凉市","酒泉市","庆阳市","定西市","陇南市",
                "临夏回族自治州","甘南藏族自治州","西宁市","海东地区","海北藏族自治州","黄南藏族自治州","海南藏族自治州","果洛藏族自治州","玉树藏族自治州","海西蒙古族藏族自治州","银川市","石嘴山市","吴忠市","固原市",
                "中卫市","乌鲁木齐市","克拉玛依市","吐鲁番地区","哈密地区","昌吉回族自治州","博尔塔拉蒙古自治州","巴音郭楞蒙古自治州","阿克苏地区","克孜勒苏柯尔克孜自治州","喀什地区","和田地区","伊犁哈萨克自治州",
                "塔城地区","阿勒泰地区","石河子市","阿拉尔市","图木舒克市","五家渠市","台北市","高雄市","基隆市","台中市","台南市","新竹市","嘉义市","台北县","宜兰县","桃园县","新竹县","苗栗县","台中县","彰化县",
                "南投县","云林县","嘉义县","台南县","高雄县","屏东县","澎湖县","台东县","花莲县","中西区","东区","九龙城区","观塘区","南区","深水埗区","黄大仙区","湾仔区","油尖旺区","离岛区","葵青区","北区",
                "西贡区","沙田区","屯门区","大埔区","荃湾区","元朗区","澳门特别行政区","海外"};
        for (int i=0;i<cityString.length;i++){
            cities.add(new City(cityString[i]));
        }
        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return PinyinUtils.getPinyin(o1.getName()).compareTo(PinyinUtils.getPinyin(o2.getName()));
            }
        });
    }
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        private List<City> cities;

        public MyAdapter(List<City> cities) {
            this.cities = cities;
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
            ViewHolder viewHolder=new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            holder.textView.setText(cities.get(position).getName());
            if (position==0){
                holder.textView1.setVisibility(View.VISIBLE);
                 holder.textView1.setText(PinyinUtils.getPinyin(cities.get(position).getName()).substring(0,1));
            }
            else {
                String lastString=cities.get(position-1).getName().toString();
                String lastPinyin=PinyinUtils.getPinyin(lastString).substring(0,1);
                if (lastPinyin.equals(PinyinUtils.getPinyin(cities.get(position).getName()).substring(0,1))){
                    holder.textView1.setVisibility(View.GONE);
                }
                else {
                    holder.textView1.setText(PinyinUtils.getPinyin(cities.get(position).getName()).substring(0,1));
                    holder.textView1.setVisibility(View.VISIBLE);
                }
            }
        }

        @Override
        public int getItemCount() {
            return cities.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            TextView textView1;
            public ViewHolder(View itemView) {
                super(itemView);
                textView=itemView.findViewById(R.id.item_textview);
                textView1=itemView.findViewById(R.id.textview1);
            }
        }
    }
}
