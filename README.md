# NoteKeeper
An NoteKeeper Android Application

# Description:
- As persisting notes was not required, NoteData class is used as an singleton that holds the notes list. It exposes an live data object that holds the list notes.This implementation can be later swapped out for a DB implementation
- The app follows an MVVM architecture
- The app does not have any tests (there should be; something that I should work on, had some issues in testing live data objects)


The apk for the above app can be found here [NoteKeeper](https://github.com/vishalambre/NoteKeeper/releases/tag/v0.1)
