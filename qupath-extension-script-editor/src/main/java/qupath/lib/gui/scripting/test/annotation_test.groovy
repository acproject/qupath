package qupath.lib.gui.scripting.test
import com.google.gson.Gson
import qupath.lib.geom.Point2
import qupath.lib.objects.PathAnnotationObject
import qupath.lib.roi.PolygonROI
import java.io.File


def text = new File("annotation_gson.json").text
def points = vertices.collect {new Point2(it[0].get(0), it[1].get(1))}
println(text)