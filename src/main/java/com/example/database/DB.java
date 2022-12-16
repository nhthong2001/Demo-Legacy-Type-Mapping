package com.example.database;

import com.example.util.LegacyTypeHandlerContact;
import io.micronaut.core.io.ResourceResolver;
import io.micronaut.core.io.scan.ClassPathResourceLoader;
import one.microstream.chars.XChars;
import one.microstream.exceptions.IORuntimeException;
import one.microstream.persistence.internal.InquiringLegacyTypeMappingResultor;
import one.microstream.persistence.types.Persistence;
import one.microstream.persistence.types.PersistenceLegacyTypeMappingResultor;
import one.microstream.storage.embedded.configuration.types.EmbeddedStorageConfiguration;
import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageFoundation;
import one.microstream.storage.types.StorageManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.time.Duration;

public final class DB {
    private static StorageManager INSTANCE = null;

    private DB() {

    }

    private static StorageManager createStorageManager(DataRoot root) {
//        EmbeddedStorageFoundation<?> foundation = EmbeddedStorageConfiguration.Builder()
//                .setStorageDirectory("data-test-contact-not-have-person")
//                .setChannelCount(1)
//                .setHousekeepingInterval(Duration.ofMillis(400))
//                .setHousekeepingTimeBudget(Duration.ofMillis(100))
//                .createEmbeddedStorageFoundation();

        // Test console y,...
//        foundation.getConnectionFoundation().setLegacyTypeMappingResultor(
//                InquiringLegacyTypeMappingResultor.New(
//                    PersistenceLegacyTypeMappingResultor.New(), 0.5));

        // Test file .0csv
//        foundation.setRefactoringMappingProvider(
//                Persistence.RefactoringMapping(provideMapping())
//        );

        // Test BinaryLegacyTypeHandler
        return EmbeddedStorage.Foundation(GetTempWorkDirectory("data-test-contact-not-have-person").toPath()).onConnectionFoundation(f ->
                f.getCustomTypeHandlerRegistry()
                        .registerLegacyTypeHandler(new LegacyTypeHandlerContact())
        ).start(root);
//        StorageManager result = foundation
//                .createEmbeddedStorageManager(root)
//                .start();

//        return result;
    }
    public static File GetTempWorkDirectory(final String name)
    {
        final File tmpPath = new File(System.getProperty("java.io.tmpdir"));
        if(tmpPath.canWrite() && tmpPath.isDirectory())
        {
            final File p = Paths.get(tmpPath.toString(), name).toFile();
            if(p.exists())
            {
                return p;
            }
            if(p.mkdir())
            {
                return p;
            }
        }

        throw new RuntimeException("Faild to get or create working directory!");
    }
    private static String provideMapping()
    {
        final ClassPathResourceLoader refactoringLoader =
                new ResourceResolver().getLoader(ClassPathResourceLoader.class).get();

        try(InputStream in = refactoringLoader.getResourceAsStream("refactoring.csv").get())
        {
            String readStringFromInputStream = XChars.readStringFromInputStream(in, StandardCharsets.UTF_8);
            return readStringFromInputStream;
        }
        catch(final IOException e)
        {
            throw new IORuntimeException(e);
        }
    }

    public static StorageManager getInstance() {
        // This is not thread safe but for training, we assume only 1 user, the developer and thus no concurrency.
        if (INSTANCE == null) {
            DataRoot root = new DataRoot();
            INSTANCE = createStorageManager(root);
        }
        return INSTANCE;
    }

    public static DataRoot getRoot() {
        // This is not thread safe but for training, we assume only 1 user, the developer and thus no concurrency.
        if (INSTANCE == null) {
            DataRoot root = new DataRoot();
            INSTANCE = createStorageManager(root);
        }
        return (DataRoot) INSTANCE.root();
    }
}
