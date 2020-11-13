package qupath.lib.gui.scripting.test

import java.io.File


//导出为Gson格式
def annotations = getAnnotationObjects();
boolean prettyPrint = true;
def gson = GsonTools.getInstance(prettyPrint);
// 打印出来
println gson.toJson(annotations);
def file = new File("annotation_gson.json");
if (file.exists())
    file.delete();
def printWirter = file.newPrintWriter();
printWirter.write(gson.toJson(annotations).toString());
printWirter.flush();
printWirter.close();

