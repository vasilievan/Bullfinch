#ifndef BULLFINCH_AUDIOENGINE_H
#define BULLFINCH_AUDIOENGINE_H

#include <oboe/Oboe.h>

using namespace oboe;

class AudioEngine: public AudioStreamCallback {
    void start();

public:
    DataCallbackResult
    onAudioReady(AudioStream *audioStream, void *audioData, int32_t numFrames) override;
};

#endif
