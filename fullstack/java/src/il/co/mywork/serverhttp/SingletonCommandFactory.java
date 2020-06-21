package il.co.mywork.serverhttp;

import il.co.mywork.command.Command;
import il.co.mywork.factory.Factory;

public class SingletonCommandFactory {
    private static class SingletonHolder {
        private static final Factory<String, Command, Object> INSTANCE = new Factory<>();
    }

    private SingletonCommandFactory() {}

    public static Factory<String, Command, Object> getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
