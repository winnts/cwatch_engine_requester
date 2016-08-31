package WebApp;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by adyachenko on 29.08.16.
 */
public class MonitorApp extends Application <MonitorAppConfiguration> {
    public static void main(String[] args) throws Exception{
        new MonitorApp().run(args);
    }

    @Override
    public String getName() {
        return "hello";
    }

    @Override
    public void initialize (Bootstrap<MonitorAppConfiguration> bootstrap){
        bootstrap.addBundle(new AssetsBundle("/webapp", "/app"));
    }

    @Override
    public void run(MonitorAppConfiguration monitorAppConfiguration, Environment environment) {
        final MonitorAppDomains resource = new MonitorAppDomains(
                monitorAppConfiguration.getTemplate(),
                monitorAppConfiguration.getDefaultName()
        );
        final MonitorAppAgents resource1 = new MonitorAppAgents(
                monitorAppConfiguration.getTemplate(),
                monitorAppConfiguration.getDefaultName()
        );
        final MonitorAppApplications resource2 = new MonitorAppApplications(
                monitorAppConfiguration.getTemplate(),
                monitorAppConfiguration.getDefaultName()
        );
        environment.jersey().register(resource);
        environment.jersey().register(resource1);
        environment.jersey().register(resource2);

    }
}
