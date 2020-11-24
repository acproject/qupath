package qupath.lib.gui.scripting.test;
import java.io.File;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;

import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.DefaultMapContext;
import org.geotools.map.MapContext;
import org.geotools.swing.JMapFrame;
import org.geotools.swing.data.JFileDataStoreChooser;

import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;
/**
 *
 * @author hx_pc
 */
public class GeotoolsTest {
    public static void main(String[] args) throws Exception {
        // display a data store file chooser dialog for shapefiles
        File file = JFileDataStoreChooser.showOpenFile("wkt", null);
        if (file == null) {
            return;
        }

        FileDataStore store = FileDataStoreFinder.getDataStore(file);
        SimpleFeatureSource featureSource = store.getFeatureSource();

        // Create a map context and add our shapefile to it
        MapContext map = new DefaultMapContext();
        map.setTitle("Quickstart");
        map.addLayer(featureSource, null);

        // Now display the map
        JMapFrame.showMap(map);
    }
}

@Platform(include = { "NativeLibrary.h, <vector>"})
@Namespace("NativeLibrary")
class NativeLibrary {
    @Name("std::vector<std::vector<void*>>")
    static class NativeClass extends Pointer {
        static {Loader.load();}
        public NativeClass() { allocate();}
        private native void allocate();
        
        public native @StdString String get_property();
        public native void set_property(String property);
        
        public native @StdString String property();
        public native void property(String property);
        
        @Name("operator=")
        public native  @ByRef NativeClass put(@ByRef NativeClass x);
        
        @Name("operator[]")
        public native @StdVector PointerPointer get(long n);
        public native @StdVector PointerPointer at(long n);
    }
    
    public static void test(String[] args) {
        NativeClass clz = new NativeClass();
        clz.set_property("Hello world!");
        System.out.println(clz.property());
    }
}
