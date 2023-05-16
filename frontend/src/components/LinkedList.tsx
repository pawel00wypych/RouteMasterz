import { useState } from 'react';

interface ListNode<T> {
    value: T;
    next: ListNode<T> | null;
}

export function useLinkedList<T>() {
    const [list, setList] = useState<ListNode<T> | null>(null);

    const insert = (value: T) => {
        const newNode: ListNode<T> = {
            value,
            next: null
        };

        if (list === null) {
            setList(newNode);
        } else {
            let current = list;
            while (current.next !== null) {
                current = current.next;
            }
            current.next = newNode;
        }
    };

    const remove = (value: T) => {
        if (list === null) {
            return;
        }

        if (list.value === value) {
            setList(list.next);
            return;
        }

        let current: ListNode<T> | null = list;
        let prev: ListNode<T> | null = null;
        while (current !== null && current.value !== value) {
            prev = current;
            current = current.next;
        }

        if (current !== null) {
            prev!.next = current.next;
        }
    };

    const toArray = (): T[] => {
        const result: T[] = [];
        let current = list;
        while (current !== null) {
            result.push(current.value);
            current = current.next;
        }
        return result;
    };

    return {
        insert,
        remove,
        toArray
    };
}
