package qupath.lib.gui.scripting.utils;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.geotools.geojson.geom.GeometryJSON;
import org.geotools.geojson.geom.MultiPolygonHandler;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKTReader;

import java.io.StringWriter;
import org.locationtech.jts.io.ParseException;

public class WKTUtil {

    public static String wktToJson(String wkt) {
        String json = null;
        try {
            WKTReader reader = new WKTReader();
            Geometry geometry = reader.read(wkt);
            
            StringWriter writer = new StringWriter();
            GeometryJSON g = new GeometryJSON();
//            g.writeMultiPolygon(geometry.get, writer);
            json = writer.toString();
        } catch (ParseException e) {
        }
        return json;
    }
    
     public static String geoToJson(String wkt) {
        String json = null;
        WKT wktObject =new WKT();
        json = wktObject.getMULTIPOLYGONWktToJson(wkt,0);
        return json;
    }
     
     public static String jsonToWkt(String geoJson) {
        String wkt = null;
        GeometryJSON gjson = new GeometryJSON();
        Reader reader = new StringReader(geoJson);
        try {
            Geometry geometry = gjson.read(reader);
             
            wkt = geometry.toText();
        } catch (IOException e) {
        }
        return wkt;
    }

    public static void main(String... args) {
        System.out.println(WKTUtil.wktToJson("POLYGON ((21376 11648, 21376 11776, 21440 11776, 21440 11840, 21568 11840, 21568 11904, 21760 11904, 21760 11968, 21824 11968, 21824 12032, 21888 12032, 21888 12160, 21952 12160, 21952 12224, 22080 12224, 22080 12288, 22400 12288, 22400 12224, 22464 12224, 22464 12160, 22528 12160, 22528 12096, 22592 12096, 22592 11968, 22464 11968, 22464 11904, 22336 11904, 22336 11840, 22208 11840, 22208 11776, 21952 11776, 21952 11712, 21760 11712, 21760 11648, 21376 11648))POLYGON ((42496 15552, 42496 15680, 42432 15680, 42432 15744, 42496 15744, 42496 15872, 42752 15872, 42752 15808, 42816 15808, 42816 15616, 42752 15616, 42752 15552, 42496 15552))POLYGON ((56128 74944, 56128 75072, 56192 75072, 56192 74944, 56128 74944))POLYGON ((70592 100032, 70592 100096, 70528 100096, 70528 100160, 70592 100160, 70592 100288, 70656 100288, 70656 100352, 70720 100352, 70720 100480, 70784 100480, 70784 100544, 70976 100544, 70976 100480, 71040 100480, 71040 100544, 71104 100544, 71104 100480, 71168 100480, 71168 100416, 71232 100416, 71232 100352, 71296 100352, 71296 100288, 71360 100288, 71360 100224, 71488 100224, 71488 100288, 71552 100288, 71552 100352, 71616 100352, 71616 100416, 71808 100416, 71808 100224, 71680 100224, 71680 100160, 71104 100160, 71104 100224, 70976 100224, 70976 100160, 70912 100160, 70912 100096, 70848 100096, 70848 100032, 70592 100032))POLYGON ((70080 77440, 70080 77504, 69952 77504, 69952 77568, 69888 77568, 69888 77632, 69760 77632, 69760 77568, 69696 77568, 69696 77504, 69440 77504, 69440 77632, 69504 77632, 69504 77696, 69568 77696, 69568 77760, 69632 77760, 69632 77824, 69760 77824, 69760 77760, 69952 77760, 69952 77824, 70144 77824, 70144 77760, 70208 77760, 70208 77696, 70272 77696, 70272 77504, 70208 77504, 70208 77440, 70080 77440))"));
    }
}
