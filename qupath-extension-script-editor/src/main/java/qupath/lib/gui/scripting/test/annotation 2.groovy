package qupath.lib.gui.scripting.test

import org.locationtech.jts.io.WKTWriter;
import java.io.File;
//导出为WKT格式
def annotations2 = getAnnotationObjects();
def writer = new WKTWriter();
annotations2.each {
    println writer.write(it.getROI().getGeometry());
}

def file2 = new File("annotation_wkt.geojson ");
if (file2.exists())
    file2.delete();
def printWirter2 = file2.newPrintWriter();
annotations2.each {
    printWirter2.write(it.getROI().getGeometry().toString());
}

printWirter2.flush();
printWirter2.close();