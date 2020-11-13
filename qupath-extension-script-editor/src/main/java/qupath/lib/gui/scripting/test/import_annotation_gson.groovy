package qupath.lib.gui.scripting.test

import com.google.gson.Gson
import qupath.lib.geom.Point2
import qupath.lib.objects.PathAnnotationObject
import qupath.lib.roi.PolygonROI
import java.io.File

import java.util.ArrayList;
boolean prettyPrint = true;
def gson = GsonTools.getInstance(prettyPrint);


def text = new File("annotation_gson.json").text

println(text)

//def text = """
//{
//"tumor": [
//  {
//   "name": "Annotation 0",
//   "vertices": [
//    [
//     100,
//     150
//    ],
//    [
//     200,
//     250
//    ],
//    [
//     300,
//     350
//    ]
//   ]
//  },
//  {
//   "name": "Annotation 1",
//   "vertices": [
//    [
//     1000,
//     1500
//    ],
//    [
//     2000,
//     2500
//    ],
//    [
//     3000,
//     3500
//    ]
//   ]
//  }
// ]
//}
//"""

// Read into a map
def map = new Gson().fromJson(text,List<Map>)

// Extract tumor & annotations
def tumorAnnotations = map['geometry']

// Convert to QuPath annotations
def annotations = []
for (annotation in tumorAnnotations) {

    def name = annotation['Feature']
    def vertices = annotation['coordinates']
    def points=new ArrayList();
    for (int i =0; i < vertices[0].size() ;i++){
//        points = vertices.collect {new Point2(it[0].collect {it[0]} , it[1].collect {it[0]})}
        points.add( new Point2(vertices[0][i][0],vertices[0][i][1]))
    }
    def polygon = new PolygonROI(points)
    def pathAnnotation = new PathAnnotationObject(polygon)
    pathAnnotation.setName(name)
    annotations << pathAnnotation
//        println(name)
//        println(vertices)
}


addObjects(annotations)