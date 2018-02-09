package net.gshp.messagesandfiles.util;

import android.content.Context;
import android.content.res.AssetManager;

import net.gshp.messagesandfiles.R;
import net.gshp.messagesandfiles.dto.DtoDataProperties;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by gnu on 1/02/18.
 */

public class ReadPropertiesAssets {

    public DtoDataProperties readPropertiesFile(Context context) {
        Properties properties = new Properties();
        DtoDataProperties dtoProperties = new DtoDataProperties();
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(context.getString(R.string.name_assets_file));
            properties.load(inputStream);
            dtoProperties.setDataBasePath(properties.getProperty(context.getString(R.string.assets_data_base_path)));
            dtoProperties.setDataBaseVersion(Integer.valueOf(properties.getProperty(context.getString(R.string.assets_data_base_version))));
            dtoProperties.setDataFilesPath(properties.getProperty(context.getString(R.string.assets_data_files_path)));
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return dtoProperties;
    }
}
