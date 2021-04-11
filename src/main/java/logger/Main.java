package logger;

import org.apache.logging.log4j.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    private static final Marker STATEMENT = MarkerManager.getMarker("STATEMENT");
    private static final Marker QUESTION = MarkerManager.getMarker("QUESTION");

    public static void fatal_statement(int counter) {
        ThreadContext.put("counter",String.valueOf(counter) + ". iteracio");
        logger.fatal(STATEMENT, "Nesze hát a rózsavíz,");
    }

    public static void error_statement(int counter) {
        ThreadContext.put("counter", String.valueOf(counter) + ". iteracio");
        logger.error(STATEMENT, "Gyöngyöm, gyöngyvirágom.");
    }

    public static void warn_question(int counter) {
        ThreadContext.put("counter", String.valueOf(counter) + ". iteracio");
        logger.warn(QUESTION, "Hol a tojás, piros tojás?");
    }

    public static void info_statement(int counter) {
        ThreadContext.put("counter", String.valueOf(counter) + ". iteracio");
        logger.info(STATEMENT, "Tarisznyámba várom.");
    }

    public static void trace(int counter) {
        ThreadContext.put("counter", String.valueOf(counter) + ". iteracio");
        logger.trace("Szabad-e locsolni?\n");
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= Integer.parseInt(args[0]); i++){
            fatal_statement(i);
            error_statement(i);
            warn_question(i);
            info_statement(i);
            trace(i);
            Thread.sleep(3000);
        }
    }
}
