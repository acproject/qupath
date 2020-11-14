package qupath.lib.gui.scripting.utils;

import org.geotools.geojson.geom.GeometryJSON;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKTReader;

import java.io.StringWriter;

public class WKTUtil {

    public static String wktToJson(String wkt) {
        String json = null;
        try {
            WKTReader reader = new WKTReader();
            Geometry geometry = reader.read(wkt);
            StringWriter writer = new StringWriter();
            GeometryJSON g = new GeometryJSON();
            g.write(geometry, writer);
            json = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    public static void main(String... args) {
        System.out.println(WKTUtil.wktToJson("MULTIPOLYGON (((30 20, 45 40, 10 40, 30 20)),\n" +
                "((15 5, 40 10, 10 20, 5 10, 15 5)))"));
    }
}
