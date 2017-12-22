package sample.controller.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Milaya on 22.12.2017.
 */
public class DateAdapter extends XmlAdapter<String, Date> {
    @Override
    public Date unmarshal(String v) throws Exception {
        DateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
        mapper.setDateFormat(fmt);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return null;
    }
}
