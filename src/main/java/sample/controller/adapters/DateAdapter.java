package sample.controller.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateFormatter
 */
public class DateAdapter extends XmlAdapter<String, Date> {
    @Override
    public Date unmarshal(String v) throws Exception {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return fmt.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return fmt.format(v);
    }
}
