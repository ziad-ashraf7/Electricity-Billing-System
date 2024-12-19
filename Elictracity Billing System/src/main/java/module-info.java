module ziad.elictracitybillingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens ziad.elictracitybillingsystem to javafx.fxml;
    exports ziad.elictracitybillingsystem;
    exports Controllers;
    exports Models;
    exports utils;
    opens Controllers to javafx.fxml;
    exports ziad.elictracitybillingsystem.Old;
    opens ziad.elictracitybillingsystem.Old to javafx.fxml;
}