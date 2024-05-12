#ifndef BULLFINCH_AUDIOENGINE_H
#define BULLFINCH_AUDIOENGINE_H

#include <oboe/Oboe.h>

using namespace oboe;

class AudioEngine : public AudioStreamCallback {
public:
    DataCallbackResult
    onAudioReady(AudioStream *audioStream, void *audioData, int32_t numFrames) override;

    void start();

    void closeStreams();

private:
    std::shared_ptr<oboe::AudioStream> recordingStream;
    std::shared_ptr<oboe::AudioStream> playStream;

    void closeStream(std::shared_ptr<oboe::AudioStream> &stream);
};

#endif
