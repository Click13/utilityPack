package com.click13.Logging;

import java.io.IOException;
import java.util.logging.Formatter;
import java.util.logging.*;

public class Logg {
    public static final Level OFF = Level.OFF;
    public static final Level SEVERE = Level.SEVERE;
    public static final Level WARNING = Level.WARNING;
    public static final Level INFO = Level.INFO;
    public static final Level CONFIG = Level.CONFIG;
    public static final Level FINE = Level.FINE;
    public static final Level FINER = Level.FINER;
    public static final Level FINEST = Level.FINEST;
    public static final Level ALL = Level.ALL;


    private Logger logger;

    public Logg() {
        logger  = Logger.getAnonymousLogger(null);
        logger.setLevel(Level.INFO);
    }

    public void setLevel(Level level){
        logger.setLevel(level);
    }

    public Level getLevel(){
        return logger.getLevel();
    }

    @Deprecated
    public void addHandler(Handler handler){
        logger.addHandler(handler);
    }

    public void addFileHandler(String filename, boolean append, Level level, Filter filter, Formatter formatter) throws IOException {
        FileHandler fileHandler = new FileHandler(filename, append);
        fileHandler.setLevel(level);
        fileHandler.setFilter(filter);
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
    }

    public void addFileHandler(String filename, Level level, Filter filter, Formatter formatter) throws IOException {
        FileHandler fileHandler = new FileHandler(filename);
        fileHandler.setLevel(level);
        fileHandler.setFilter(filter);
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
    }

    public void addConsoleHandler(Level level, Filter filter, Formatter formatter){
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(formatter);
        consoleHandler.setLevel(level);
        consoleHandler.setFilter(filter);
        logger.addHandler(consoleHandler);
    }

    public void logg(Level level, String message){
    logger.log(level, message);
    }

    public void logg(Level level, String message, Throwable thrown){
        logger.log(level, message, thrown);
    }
}
