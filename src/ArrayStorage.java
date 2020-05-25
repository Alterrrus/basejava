import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int i = 0;

    void clear() {
        Arrays.fill(storage, null);
        i=0;
    }

    void save(Resume r) {
        storage[i] = r;
        i++;
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume.getUuid().equals(uuid)) {
                return resume;
            }
        }
        return null;

    }

    void delete(String uuid) {
        int f=0;
        for (int i1 = 0; i1 < i; i1++) {
            if (storage[i1].getUuid().equals(uuid)){
                 f=i1;
            }
        }
        if (i - f >= 0) System.arraycopy(storage, f + 1, storage, f, i - f);
        i--;

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result=new Resume[i];
        System.arraycopy(storage, 0, result, 0, i);
        return result;
    }

    int size() {

        return i;
    }
}
