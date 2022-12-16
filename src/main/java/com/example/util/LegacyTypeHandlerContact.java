package com.example.util;

import com.example.model.Contact;
import com.example.model.Person;
import one.microstream.X;
import one.microstream.persistence.binary.types.Binary;
import one.microstream.persistence.binary.types.BinaryLegacyTypeHandler;
import one.microstream.persistence.types.PersistenceLoadHandler;
import one.microstream.persistence.types.PersistenceReferenceLoader;

public class LegacyTypeHandlerContact extends BinaryLegacyTypeHandler.AbstractCustom<Contact> {
    private static final long
            BINARY_OFFSET_name = 0,
            BINARY_OFFSET_firstname = BINARY_OFFSET_name + Binary.objectIdByteLength(),
            BINARY_OFFSET_age = BINARY_OFFSET_firstname + Binary.objectIdByteLength(),
            BINARY_OFFSET_email = BINARY_OFFSET_age + Binary.objectIdByteLength(),
            BINARY_OFFSET_note = BINARY_OFFSET_email + Binary.objectIdByteLength(),
            BINARY_OFFSET_link = BINARY_OFFSET_note + Binary.objectIdByteLength();


    public LegacyTypeHandlerContact()
    {
        //introduce the field names of the legacy class
        super(Contact.class,
                X.List(CustomField(String.class,"name"),
                        CustomField(String.class,"firstname"),
                        CustomField(int.class,"age"),
                        CustomField(String.class,"email"),
                        CustomField(String.class,"note"),
                        CustomField(Object.class,"link")
                ));
    }

    @Override
    public boolean hasPersistedReferences()
    {
        // persisted data records have references to other persisted data records
        return true;
    }

    @Override
    public boolean hasVaryingPersistedLengthInstances()
    {
        /*the same instance can never have a varying persisted length, since the NicePlace class
         *only has to references as member.
         *
         * Collections are an example for variable length instances.
         * The same collection instance can contain 2 elements at one store and 3 at another store.
         */

        return false;
    }


    @Override
    public Contact create(
            final Binary bytes,
            final PersistenceLoadHandler loadHandler
    )
    {
        //required instances may not be available, yet, at creation time. Thus create dummy and fill in #update.
        return new Contact();
    }

    @Override
    public void updateState(
            final Binary bytes,
            final Contact instance,
            final PersistenceLoadHandler handler
    )
    {
        //get the data of the legacy Contact fields
        final String name = (String)handler.lookupObject(bytes.read_long(BINARY_OFFSET_name));
        final String firstname  = (String)handler.lookupObject(bytes.read_long(BINARY_OFFSET_firstname));
        final int age = (int)handler.lookupObject(bytes.read_long(BINARY_OFFSET_age));
        final String email  = (String)handler.lookupObject(bytes.read_long(BINARY_OFFSET_email));
        final String note  = (String)handler.lookupObject(bytes.read_long(BINARY_OFFSET_note));
        final Object link  = (Object) handler.lookupObject(bytes.read_long(BINARY_OFFSET_link));

        //initialize the new version of our Contact
        instance.setPerson(new Person());
//        instance.setPerson(new Person(name, firstname,age, email));
        instance.setNote(note);
        instance.setLink(link);

    }

    @Override
    public void iterateLoadableReferences(
            final Binary bytes,
            final PersistenceReferenceLoader iterator
    )
    {
        iterator.acceptObjectId(bytes.read_long(BINARY_OFFSET_name));
        iterator.acceptObjectId(bytes.read_long(BINARY_OFFSET_firstname));
        iterator.acceptObjectId(bytes.read_long(BINARY_OFFSET_age));
        iterator.acceptObjectId(bytes.read_long(BINARY_OFFSET_email));
        iterator.acceptObjectId(bytes.read_long(BINARY_OFFSET_note));
        iterator.acceptObjectId(bytes.read_long(BINARY_OFFSET_link));
    }
}
