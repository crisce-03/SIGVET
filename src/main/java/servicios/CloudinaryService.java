package servicios;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.util.Map;

public class CloudinaryService {

    private Cloudinary cloudinary;

    public CloudinaryService() {

        cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dr5enicul",
                "api_key", "247659145442825",
                "api_secret", "uAnUb9TnXkdfRrWeiQ7XQnzWF6Q"
        ));
    }

    public String subirImagen(File archivo) {

        try {

            Map resultado = cloudinary.uploader().upload(
                    archivo,
                    ObjectUtils.emptyMap()
            );

            return resultado.get("secure_url").toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}