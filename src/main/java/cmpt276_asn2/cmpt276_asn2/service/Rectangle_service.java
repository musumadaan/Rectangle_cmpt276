package cmpt276_asn2.cmpt276_asn2.service;

import java.util.List;

import cmpt276_asn2.cmpt276_asn2.models.Rectangle;

public interface Rectangle_service {
    List<Rectangle> getAllRectangles();
    void saveRectangle(Rectangle rectangle);
    Rectangle getRectangleById(Integer id);
    void deleteRectangleById(Integer id);
}
